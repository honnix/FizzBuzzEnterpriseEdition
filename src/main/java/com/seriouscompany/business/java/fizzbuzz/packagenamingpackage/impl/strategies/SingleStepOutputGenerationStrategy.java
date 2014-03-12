package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.BuzzStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.BuzzStringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.FizzStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.FizzStringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.IntIntegerPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.IntegerPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.IsEvenlyDivisibleStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.NewLineStringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.NoFizzNoBuzzStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.StringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.IntegerPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.IsEvenlyDivisibleStrategy;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.SingleStepOutputGenerationParameter;

public class SingleStepOutputGenerationStrategy {

	private IsEvenlyDivisibleStrategy myFizzStrategy;
	private StringPrinter myFizzStringPrinter;

	private IsEvenlyDivisibleStrategy myBuzzStrategy;
	private StringPrinter myBuzzStringPrinter;

	private IsEvenlyDivisibleStrategy myNoFizzNoBuzzStrategy;
	private IntegerPrinter myIntIntegerPrinter;

	private StringPrinter myNewLinePrinter;

	public SingleStepOutputGenerationStrategy() {
		final IsEvenlyDivisibleStrategyFactory myFizzStrategyFactory = new FizzStrategyFactory();
		myFizzStrategy = myFizzStrategyFactory.createIsEvenlyDivisibleStrategy();
		final StringPrinterFactory myFizzStringPrinterFactory = new FizzStringPrinterFactory();
		myFizzStringPrinter = myFizzStringPrinterFactory.createStringPrinter();

		final IsEvenlyDivisibleStrategyFactory myBuzzStrategyFactory = new BuzzStrategyFactory();
		myBuzzStrategy = myBuzzStrategyFactory.createIsEvenlyDivisibleStrategy();
		final StringPrinterFactory myBuzzStringPrinterFactory = new BuzzStringPrinterFactory();
		myBuzzStringPrinter = myBuzzStringPrinterFactory.createStringPrinter();

		final IsEvenlyDivisibleStrategyFactory myNoFizzNoBuzzStrategyFactory = new NoFizzNoBuzzStrategyFactory();
		myNoFizzNoBuzzStrategy = myNoFizzNoBuzzStrategyFactory.createIsEvenlyDivisibleStrategy();
		final IntegerPrinterFactory myIntIntegerPrinterFactory = new IntIntegerPrinterFactory();
		myIntIntegerPrinter = myIntIntegerPrinterFactory.createPrinter();

		final StringPrinterFactory myNewLineStringPrinterFactory = new NewLineStringPrinterFactory();
		myNewLinePrinter = myNewLineStringPrinterFactory.createStringPrinter();
	}

	public void performGenerationForCurrentStep(SingleStepOutputGenerationParameter generationParameter) {
		final int nGenerationParameter = generationParameter.retrieveIntegerValue();
		if (myFizzStrategy.isEvenlyDivisible(nGenerationParameter)) {
			myFizzStringPrinter.print();
		}
		if (myBuzzStrategy.isEvenlyDivisible(nGenerationParameter)) {
			myBuzzStringPrinter.print();
		}
		if (myNoFizzNoBuzzStrategy.isEvenlyDivisible(nGenerationParameter)) {
			myIntIntegerPrinter.printInteger(nGenerationParameter);
		}
		myNewLinePrinter.print();
	}
}
