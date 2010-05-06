package de.gaalop.maple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import de.gaalop.cfg.AssignmentNode;
import de.gaalop.cfg.BlockEndNode;
import de.gaalop.cfg.BreakNode;
import de.gaalop.cfg.ControlFlowVisitor;
import de.gaalop.cfg.EndNode;
import de.gaalop.cfg.IfThenElseNode;
import de.gaalop.cfg.LoopNode;
import de.gaalop.cfg.Macro;
import de.gaalop.cfg.Node;
import de.gaalop.cfg.SequentialNode;
import de.gaalop.cfg.StartNode;
import de.gaalop.cfg.StoreResultNode;
import de.gaalop.clucalc.input.UsedVariablesVisitor;
import de.gaalop.dfg.Addition;
import de.gaalop.dfg.BaseVector;
import de.gaalop.dfg.Division;
import de.gaalop.dfg.Equality;
import de.gaalop.dfg.Exponentiation;
import de.gaalop.dfg.Expression;
import de.gaalop.dfg.ExpressionVisitor;
import de.gaalop.dfg.FloatConstant;
import de.gaalop.dfg.FunctionArgument;
import de.gaalop.dfg.Inequality;
import de.gaalop.dfg.InnerProduct;
import de.gaalop.dfg.LogicalAnd;
import de.gaalop.dfg.LogicalOr;
import de.gaalop.dfg.MacroCall;
import de.gaalop.dfg.MathFunctionCall;
import de.gaalop.dfg.Multiplication;
import de.gaalop.dfg.MultivectorComponent;
import de.gaalop.dfg.Negation;
import de.gaalop.dfg.OuterProduct;
import de.gaalop.dfg.Relation;
import de.gaalop.dfg.Reverse;
import de.gaalop.dfg.Subtraction;
import de.gaalop.dfg.Variable;

/**
 * This class is responsible for inlining user-defined macros at places where macros are called.
 * 
 * @author Christian Schwinn
 * 
 */
public class InlineMacrosVisitor implements ControlFlowVisitor, ExpressionVisitor {

	private SequentialNode currentStatement;
	private List<Expression> currentArguments;
	private Set<String> usedVariables = new HashSet<String>();
	private Set<Node> visitedNodes = new HashSet<Node>();

	private String generateUniqueName(String original) {
		if (usedVariables.contains(original)) {
			Random r = new Random(System.currentTimeMillis());
			String unique;
			do {
				unique = original + "__" + r.nextInt(100);
			} while (usedVariables.contains(unique));
			return unique;
		} else {
			return original;
		}
	}

	/**
	 * Prevents visited nodes from being visited again and causing a potential infinite loop.
	 * 
	 * @param node node from which to continue visiting
	 */
	private void continueVisitFrom(SequentialNode node) {
		if (!visitedNodes.contains(node.getSuccessor())) {
			visitedNodes.add(node.getSuccessor());
			node.getSuccessor().accept(this);
		}
	}

	@Override
	public void visit(StartNode node) {
		for (Variable input : node.getGraph().getInputVariables()) {
			usedVariables.add(input.getName());
		}
		for (Variable local : node.getGraph().getLocalVariables()) {
			usedVariables.add(local.getName());
		}
		continueVisitFrom(node);
	}

	@Override
	public void visit(AssignmentNode node) {
		currentStatement = node;
		node.getValue().accept(this);
		continueVisitFrom(node);
	}

	@Override
	public void visit(StoreResultNode node) {
		node.getValue().accept(this);
		continueVisitFrom(node);
	}

	@Override
	public void visit(IfThenElseNode node) {
		node.getCondition().accept(this);
		node.getPositive().accept(this);
		node.getNegative().accept(this);
		continueVisitFrom(node);
	}

	@Override
	public void visit(BlockEndNode node) {
	}

	@Override
	public void visit(LoopNode node) {
		// TODO Auto-generated method stub

		continueVisitFrom(node);
	}

	@Override
	public void visit(BreakNode node) {
		// TODO Auto-generated method stub

		continueVisitFrom(node);
	}

	@Override
	public void visit(Macro node) {
		node.getGraph().removeNode(node);
		continueVisitFrom(node);
	}

	@Override
	public void visit(EndNode node) {
	}

	private void handleBinaryOp(Expression l, Expression r) {
		l.accept(this);
		r.accept(this);
	}

	@Override
	public void visit(Subtraction node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Addition node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Division node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(InnerProduct node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Multiplication node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(MathFunctionCall node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Variable node) {
	}

	@Override
	public void visit(MultivectorComponent node) {
	}

	@Override
	public void visit(Exponentiation node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(FloatConstant node) {
	}

	@Override
	public void visit(OuterProduct node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(BaseVector node) {
	}

	@Override
	public void visit(Negation node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Reverse node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(LogicalOr node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(LogicalAnd node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Equality node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Inequality node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(Relation node) {
		handleBinaryOp(node.getLeft(), node.getRight());
	}

	@Override
	public void visit(FunctionArgument node) {
		Expression arg = currentArguments.get(node.getIndex() - 1);
		currentStatement.replaceExpression(node, arg);
	}

	@Override
	public void visit(MacroCall node) {
		SequentialNode caller = currentStatement;
		Macro macro = caller.getGraph().getMacro(node.getName());
		currentArguments = node.getArguments();
		for (SequentialNode statement : macro.getBody()) {
			caller.insertBefore(statement);
			statement.accept(this);
			replaceUsedVariables(statement);
		}
		Expression returnValue = macro.getReturnValue();
		replaceUsedVariablesInExpression(returnValue);
		caller.replaceExpression(node, returnValue);

		
		// reset cache and add new variables to prevent reuse
		usedVariables.addAll(usedNewNames);
		newNamesCache = null;
		usedNewNames.clear();
	}
	
	private Map<String, String> newNamesCache;
	private Set<String> usedNewNames = new HashSet<String>();

	private void replaceUsedVariables(SequentialNode statement) { 
		if (statement instanceof AssignmentNode) {
			AssignmentNode assignment = (AssignmentNode) statement;
			replaceUsedVariablesInExpression(assignment.getVariable());
			replaceUsedVariablesInExpression(assignment.getValue());
		}
		if (statement instanceof StoreResultNode) {
			replaceUsedVariablesInExpression(((StoreResultNode) statement).getValue());
		}
	}
	
	private void replaceUsedVariablesInExpression(Expression e) {
		UsedVariablesVisitor visitor = new UsedVariablesVisitor();
		e.accept(visitor);
		Set<Variable> variables = visitor.getVariables();
		if (newNamesCache == null) {
			newNamesCache = new HashMap<String, String>();
			for (String name : usedVariables) {
				newNamesCache.put(name, generateUniqueName(name));
			}
		}
		for (Variable v : variables) {
			if (usedVariables.contains(v.getName())) {
				String unique = newNamesCache.get(v.getName());
				usedNewNames.add(unique);
				e.replaceExpression(v, new Variable(unique));
			}
		}
	}

}
