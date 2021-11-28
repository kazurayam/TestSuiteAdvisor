# How to let TestCases in a TestSuite to abandon after one TestCase failed

## Problem to solve

A topic in the Katalon User Forum wrote:

- [Stop all test suite if one test case failed](https://forum.katalon.com/t/stop-all-test-suite-if-one-test-case-failed/49629)

>Hi,
>there is a way to stop a test suite if one of its cases fails?
>I need some method or form to stop the suite, does anyone have a solution?

It is quite easy to understand why this feature is required. 

Let me assume I have a Test Suite `TS1` is comprised with 3 Test Cases: `TC1`, `TC2`, `TC3`. 
 The `TC3` runs very long (e.g, 20 minutes). The `TC2` normally passes but occasionally fails.
When I run the `TS1` and unfortunately the `TC2` failed, I want the `TS1` stops as soon as the `TC2` failed.
I do not want to wait for the `TC3` to finish after 20 minutes.

However Katalon Studio does not support the feature to stop a Test Suite when a comprising Test Case failed.

What else can I do practically to let a Test Suite to finish as soon as a Test Case failed?

## Solution

A *Copernican Revolution* is required. 
Do not ask Katalon Studio to control it, which I think is not likely to be ever implemented. 
Rather *each Test Cases determine if they continue or abandon*, which you can achieve yourself.

I will introduce a `GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED` of Boolean type, with the initial value of `false`.

I will write a Test Listener with `@AfterTestCase`-annotated method. The method will check the status of each
Test Cases. If the Test Case has failed, then the method will set `GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED` 
to be `true`.

Finally I will write all Test Case scripts to check, at the very start of scripts, if they can continue or abandon.
If a Test Case find that any preceding Test Case failed, then the Test Case should stop and return without
continuing the body of test processing.

## Description




You want instroduce a `GlobalVariable.ONE_OR_MORE_TESTCASE_FAILED`. Initial initial value should be `false`.

