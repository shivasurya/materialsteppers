# Material Design Steppers

[ ![Download](https://api.bintray.com/packages/shivasurya/materialsteppers/materialstepper/images/download.svg) ](https://bintray.com/shivasurya/materialsteppers/materialstepper/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Material%20Design%20Steppers-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3049)

Based on the official [Google Material Design Guide](https://www.google.com/design/spec/material-design/) for [Stepper Components](https://www.google.com/design/spec/components/steppers.html)

    compile 'ivb.com.materialstepper:material-stepper:0.0.2'

1. Create Java Class and Extend `progressMobileStepper` or `simpleMobileStepper` Activity
- Implement Methods `List<Class> init()` method and `void onStepperCompleted()`
- Create Fragments by Extending `stepperFragment` and implement Method `boolean onNextButtonHandler()`
- Use `onNextButtonHandler` method to handle UI validation inside Fragments, whenever the user presses the Next Button, return true/false in order to determine to Stay or move to next Fragment
- Make it as ArrayList with Class containing fragments and return via `List<Class> init()` method - Mentioned in 1st point
- use `onStepperCompleted` method to complete stepper and finalize the activity

### Notes

- It's up to the developer to use `savedInstanceState` to save the data since the fragments will be initialized only when needed. Often they will be destroyed to avoid memory overhead and Leaks.
- With the given List size, step count will be Computed and Updated, Increasing and dynamic fragment feature may be added in future Commits, Scrollview have been adopted for ViewPager(fragment) inbuilt to scroll, So no worries for small/Large Screens. Added support for both Landscape and Portait Mode by adopting SavedInstanceState. (However Your Data inside fragment is not guaranteed so, use `savedInstanceState`).

## DEMO

Included the Example Demo app in <a href="https://github.com/shivasurya/materialsteppers/tree/master/example">example project</a>, download and Sync with gradle.build

![Screenshot](/screenshot/sample.gif?raw=true)

[More example screenshots](https://goo.gl/photos/mXdHHMbS8tY9akQ6A)

## Use of this Library

1. Payment Processing Steps for Checkouts
- Account verification and creation
- Survey Apps and Form fillup driven apps (Highly Recommended)
- Any Accomplishment apps and Task driven apps

## Motive behind this Library

Hello, I'm shivasurya, Pre-Final year UG Student from INDIA

I have been developing apps for more than a year, developed Android Material Design Component using Existing Support Library v4 ViewPager named as Material Steppers. Initially developed for part of College Project and open sourced for further development and enhancement of the library on GitHub. Constantly working on the library to improve features and fix memory Leaks based on issues opened. It has been published in Android Arsenal too.

Android Arsenal - https://android-arsenal.com/details/1/3049

Please Do Contribute and Optimize the code as possible.

## License

    The MIT License (MIT)

    Copyright (c) Shivasurya S

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
