# material design Steppers
#### Google Material Design Steppers Component  - Android Java - <a href="https://www.google.co.in/design/spec/components/steppers.html">Official Link</a>

  [ ![Download](https://api.bintray.com/packages/shivasurya/materialsteppers/materialstepper/images/download.svg) ](https://bintray.com/shivasurya/materialsteppers/materialstepper/_latestVersion) 
<br>
`compile 'ivb.com.materialstepper:material-stepper:0.0.1'`

#####Steps to Add To your Project :
<ol>
<li> Download the library (i have added to jcenter and waiting for approval) or add in your libs folder </li>
<li> Extend your Activity -> from <b>mobileStepperSimple</b> Class </li>
<li> Implement the Methods <b>initApp</b> and <b>onStepperCompleted</b></li>
<li> Basically Every Steps will be Fragments and will be handling UserInteraction,so create,Extend your fragments from <b>stepperFragment</b> </li>
<li> Implement the Method <b>onNextButtonHandler</b> which should return <b>true/false</b> to determine the Library to Move Ahead for next Step,So write your UI validations here and return appropriately.</li>
<li> In your Activity create Objects for your fragments made with <b>stepperFragment</b> ,create as many fragments for your use </li>
<li> Create <b>List<stepperFragment></b> and add all the object of fragments.</li>
<li> Inside your <b>initApp</b> overriden Method, just <b>setFragments(PASS_LIST_OF_FRAGMENTS)</b> </li>>
<li> finally call <b>init() </b> method from your initApp() method </li>
<li> Use <b>onStepperCompleted() </b> for taking actions after the Stepper fragments are completely done by the user </li>
</ol>
<blockquote><b>Note : with the given List size : step count will be Computed and Updated,Increasing and dynamic fragment feature will be added in future Commits,
Scrollview have been adopted for fragment inbuilt to scroll,So no worries for small screens and large layout.</b>
</blockquote>
###DEMO : 
Included the Example Demo app in <a href="https://github.com/shivasurya/materialsteppers/tree/master/medicalapp">Example Medical App project</a>,Download and Sync with gradle.build <br>
<b>Screenshot : </b>
<hr>
<img src="https://raw.githubusercontent.com/shivasurya/materialsteppers/master/screenshot/sample.gif" alt="demo screenshot"> <br />

### Use of this Library :
<ol>
<li> Payment Processing Steps for Checkouts </li>
<li> Account verification and creation </li>
<li> Survey Apps and Form fillup driven apps (Highly Recommended) </li>
<li> Any Accomplishment apps and Task driven apps. </li>
</ol>

##Motive behind this Library:

Hello,i'm <a href="http://www.i-visionblog.com/"><b>shivasurya</b></a>,Pre-Final year UG Student from INDIA<br />
i have been developing apps for more than a year,recently working for Medical related app which deals with the Collecting Patient Details.since plain Intent based and Activity Fragment will be Monotonous for End user,i searched for Design library and came across the Stepper component and till Date no one have implemented yet,so i managed to release my First version of simple Mobile Stepper Library will be helpful others.
<br />
Please Do Contribute and Optimize the code as possible.

##License 
The MIT License (MIT)

Copyright (c) 2015 s.shivasurya

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
