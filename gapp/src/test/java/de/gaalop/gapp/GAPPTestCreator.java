package de.gaalop.gapp;

import de.gaalop.gapp.codegen.GAPPCodeGeneratorPlugin;
import de.gaalop.CodeGenerator;
import de.gaalop.CodeGeneratorException;
import de.gaalop.CodeGeneratorPlugin;
import de.gaalop.CodeParser;
import de.gaalop.CodeParserException;
import de.gaalop.InputFile;
import de.gaalop.OutputFile;
import de.gaalop.gapp.executer.Executer;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.gaalop.OptimizationException;
import de.gaalop.cfg.ControlFlowGraph;
import de.gaalop.gapp.importing.GAPPImportingMain;

/**
 *
 * @author christian
 */
public class GAPPTestCreator {

    public static void main(String[] args) throws Exception {
        new GAPPTestCreator();
    }

    public GAPPTestCreator() throws Exception {
        beginTestCase();

        // =============== insert new tests here ======================
        testCircle();

        endTestCase();
    }

    private PrintWriter out;

    private void beginTestCase() {
        try {
            out = new PrintWriter("src/test/java/de/gaalop/gapp/generatedTests/GAPPTest.java");

            out.println("package de.gaalop.gapp.generatedTests;\n");

            out.println("import de.gaalop.CodeParserException;");
            out.println("import de.gaalop.OptimizationException;");
            out.println("import de.gaalop.gapp.executer.Executer;");
            out.println("import org.junit.Test;");
            out.println("import de.gaalop.gapp.*;");
            out.println("import static org.junit.Assert.*;");
            out.println("import org.junit.Ignore;");
            out.println();
            out.println("@Ignore"); //TODO chs remove this is error is detected in executer
            out.println("public class GAPPTest extends Base {");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GAPPTestCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void endTestCase() {
            out.println("}");

            out.close();
    }

    private void testCircle() throws OptimizationException {
        test("Circle");
    }

    private void test(String className) {
        out.println("@Test");
        out.println("public void test"+className+"() {");
        out.println("        try {");
        out.println("            "+className+" c = new "+className+"();");
        out.println("            Executer executer = executeProgramm(c, \""+className+"\");");
        out.println("            c.testOutput(executer);");
        out.println("        } catch (OptimizationException ex) {");
        out.println("            assertTrue(\"Optimization Error\", false);");
        out.println("        } catch (CodeParserException ex) {");
        out.println("             assertTrue(\"Code Parse Error\", false);");
        out.println("        }");
        out.println("}");
        out.println();
    }
   



    



}
