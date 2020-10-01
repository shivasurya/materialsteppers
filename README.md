# Material Design Steppers 
[ ![Download](https://api.bintray.com/packages/shivasurya/materialsteppers/materialstepper/images/download.svg) ](https://bintray.com/shivasurya/materialsteppers/materialstepper/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Material%20Design%20Steppers-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3049)
#### Google Material Design Steppers Component  For Android Java - <a href="https://www.google.co.in/design/spec/components/steppers.html">Official Link</a>
<br>
`compile 'ivb.com.materialstepper:material-stepper:0.0.2'`
<br />
<br />
1. Create Java class and extend the **progressMobileStepper** or **simpleMobileStepper** Activity.<br/>
2. Implement the following methods: **List<Class> init()** method and **void onStepperCompleted()** .<br />
3. Create Fragments by Extending **stepperFragment** and implement Method **boolean onNextButtonHandler()**.<br/>
4. Use **onNextButtonHandler** method to handle UI validation inside the Fragments, whenever the user presses the Next Button, return true/false inorder to determine whether to Stay or move to next Fragment.<br/>
5. Make it an ArrayList with Class containing fragments and return via **List<Class> init()** method - as mentioned in the 1st step.<br/>
6. Use **onStepperCompleted** method to complete stepper and finalize the activity.<br/>
7. Developers can choose to implement savedInstanceState s to save the Data if need be. The fragments will be imitialized only when needed. Most of the time they will be destroyed to avoid memory overheads and leaks.



<hr>
**Note** : with the given List size : step count will be Computed and Updated. Increasing and dynamic fragment feature could be added in upcoming releases,<br>
Scrollview has been adapted for ViewPager(fragment)scroll, This will scaled to all screen sizezes. Added support for both Landscape and Portait Mode by adapting SavedInstanceState.(However Your Data inside that fragment is not gauranteed for consistency, so the usage SavedinstanceState is suggested)
##DEMO : 
Here is a demo for your understaning: <a href="https://github.com/shivasurya/materialsteppers/tree/master/example">example project</a>, Download and Sync with gradle.build <br>
###Screenshot :
<a href = "https://goo.gl/photos/mXdHHMbS8tY9akQ6A" > Screenshot Link </a><br />
## Potential use-cases for this Library :
1) Payment Processing Steps for Checkouts <br />
2) Account creation and validation <br />
3) Forms and surveys (Ideal use-case) <br />
4) Accomplishment apps and Task driven apps. <br >
<hr>

##Motive behind this Library:
<strike>Hello,i'm shivasurya,Pre-Final year UG Student from INDIA<br />
i have been developing apps for more than a year,Developed Android Material Design Component using Existing Support Library v4 ViewPager named as Material Steppers.Initially developed for part of College Project and open sourced for further development and enhancement of the library in Github.Constantly working on the library to improve features and fix memory Leaks based on issues opened.It has been published in Android-arsenal too.</strike>


Android Arsenal - https://android-arsenal.com/details/1/3049
<br />
Please Do Contribute and Optimize the code!.

##License 
The MIT License (MIT)

Project Maintained By Shivasurya S

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
