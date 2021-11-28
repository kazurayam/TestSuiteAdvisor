# Test Suite Advisor --- how to let TestCases in a TestSuite to break after one TestCase failed

## Problem to solve

A topic in the Katalon User Forum wrote:

- [Stop all test suite if one test case failed](https://forum.katalon.com/t/stop-all-test-suite-if-one-test-case-failed/49629)

>Hi,
>there is a way to stop a test suite if one of its cases fails?
>I need some method or form to stop the suite, does anyone have a solution?

Fair enough requirement, I think. 
Let me assume I have a Test Suite `TS1` is comprised with 3 Test Cases: `TC1`, `TC2`, `TC3`. 
 The `TC3` runs very long (e.g, 20 minutes). The `TC2` normally passes but occasionally fails.
When I run the `TS1` and unfortunately the `TC2` failed, I want the `TS1` stops as soon as the `TC2` failed.
I do not want to wait for the `TC3` to finish after 20 minutes.

However Katalon Studio does not support the feature to stop a Test Suite when a comprising Test Case failed.

What else can I do practically to let a Test Suite to finish as soon as a Test Case failed?

## Solution

I will not ask Katalon Studio to control if it should invoke each Test Cases (TC1, TC2, TC3) or not.

Rather, I would write *each Test Cases to check if any of preceding Test Cases has failed*. 
If they any failed, then they should quit immediately before executing the body of test processes.

How a Test Case can find if any of its preceding Test Cases in a Test Suite failed? --- I will introduce 


## Description




You want instroduce a `GlobalVariable.ONE_OR_MORE_TESTCASE_FAILED`. Initial initial value should be `false`.

