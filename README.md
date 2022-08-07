# selenium-oscommerce

Oscommerce used for testing trainings or improve your testing skills

## Application context

Selenium is an open-source tool that automates Web browsers. It provides a single interface that lets you write test scripts in programming languages like Java, among others.

## Output

Two test executions in:

[selenium-oscommerce\src\TestCases\TestCase1.java](src/TestCases/TestCase1.java)

```
	@Test
	void test1() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Samsung");
		process.addToCart();
		process.updateQuantity("2");
		process.signInProcess();
		process.processOrderAndConfirm();
	}
	
	@Test
	void test2() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Beloved");
		process.addToCart();
		process.updateQuantity("3");
		process.signInProcess();
		process.processOrderAndConfirm();
	}
```

## Demo

![Demo video](demo/demo.gif)

## Deliverable

that includes:

1. Java EE Eclipse project with the source code. You should use Maven build because the project is clean.
2. A demo video.

Download the files as a zip using the green button, or clone the repository to your machine using Git.
