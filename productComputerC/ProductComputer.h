/*
 * ProductComputer.h
 *
 *  Created on: 22.11.2011
 *      Author: christian
 */

#ifndef PRODUCTCOMPUTER_H_
#define PRODUCTCOMPUTER_H_

#include "stdTypes.h"
#include "Algebra.h"
#include "Multivector.h"
#include "BladeArray.h"
#include "ListOfBlades.h"
#include "SumOfBlades.h"
#include "ProductCalculator.h"
#include "BaseVectors.h"

typedef list<BladeStr> bladeStrList;
typedef unordered_map<string, bladeStrList> mapStringBladestrlist;
typedef unordered_map<int, BladeArray> mapIntBladearray;



class ProductComputer {
private:
	unordered_map<int, BladeArray> mapBaseChangeToZeroInf;
    ListOfBlades listOfBlades;
    vector<SumOfBlades> bladesPM;
    unordered_map<int,int> baseSquares;

    void convertMap(mapStringBladestrlist& mapBaseChangeStr, BaseVectors& baseVectors, mapIntBladearray& result);
    void convertBladeStrToBlade(const BladeStr& bladeStr,  BaseVectors& baseVectors, Blade& result);
    void changeBaseOfBlade(const SumOfBlades& sumOfBlades, unordered_map<int, BladeArray>& map, SumOfBlades& result);
    void changeBaseOfBlade(const Blade& blade, unordered_map<int, BladeArray>& map, SumOfBlades& resultB);
public:
	ProductComputer();
	virtual ~ProductComputer();

	void initialize(const Algebra& algebra);
	void calcProduct(const int i,const  int j,  ProductCalculator& calculator, Multivector& result);
};

#endif /* PRODUCTCOMPUTER_H_ */