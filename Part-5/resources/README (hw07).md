MODEL:
CHANGES TO THE MODEL:
Since the last tick and the first tick from the model's directions were needed,
two getters (getLastTick and getFirstTick) were added to the model. Additionally,
a Canvas interface was made to allow the getters within the Canvas class to be public.
As a result, the getters getCanvasX, getCanvasY, getCanvasWidth, and getCanvasHeight in the model
were replaced with a single getter for the canvas, getCanvas.

VIEW:
CHANGES TO THE VIEW:
From the last assignment, we have changed the textual, visual, and SVG views so that they no
longer take in a model. Instead the textual and svg views takes in a hashmap of directions and
the visual view takes in a canvas. This was done to separate the view from the model, making
them more loosely coupled. In the last assignment, we had no controller and therefore
controlled the tick in the view for the visual rendering. We changed this and started
maintaining the tick in the controller. As a result, we needed an additional method in the
view and created a Visual interface, AnimatorVisual. This interface extends the original
AnimatorView interface so that a visual view is still an instance of an
AnimatorView. A very similar change was made for the SVG view, an SVG interface extending the 
original interface was created. If the render method in the original
interface was not needed, an unsupported operation exception was thrown.

INTERACTIVE VIEW:
A new interface extending the original AnimatorView was created for the interactive view
, AnimatorInteractive. The implementing class, InteractiveAnimatorView, throws an unsupported
operation exception for the render method not needed. This class contains fields for the tempo
as well as a drawingPanel. The drawingPanel (class extending JPanel) from the visual view was
re-used. 4 buttons, one for restarting, looping, speeding up, and slowing down were initialized
and added into panels to nicely format then. Additionally, there is a label to show the
current tempo. In the InteractiveAnimatorView, we have methods to set action and key
listeners, to render the view of a shape at a given tick, increase and decrease the tempo,
get the tempo, set text for the current speed label, and set the text for the current status of 
the loop button (enabled or disabled). The Excellence and factory class, AnimatorViewCreator were 
adjusted to account for this new interactive class.
       
CONTROLLER:
A controller interface, AnimatorController, was created for this assignment. This interface
contains the playAnimation method which will render one of the views when run depending on the
implementing controller class. We have 2 classes directly implementing this interface, the
EasyAnimatorController, which can be used to render a textual or SVG view, and the
VisualAnimatorController class which can render a visual view by using a timer to maintain
the tick. For the interactive view, since additional methods other than playAnimation were
needed, an interface InteractiveController extending the original interface was created
containing two additional methods, one for handling button presses and one for handling
key presses. The implementing class, InteractiveAnimatorController, implements
playAnimation using these two helper methods. The helper method executeAction handles button
presses (restart, loop, speed up, and slow down buttons). The helper method executeKey handles
key presses (space bar causes the animation to pause/resume/start).


PROGRAMMATICALLY GENERATED ANIMATION: An interface called IInputShapes, and class GenerateInput,
InputRect and InputFileGenerator was used to do this part of the assignment. To programmatically 
generate a txt file we set some values for the attributes of the rectangle which is under the class
called InputRect, here we also use getters since we need access to certain features of a rectangle
for our animation. The class GenerateInput is where we actually use an algorithm to generate 
a txt which we call musicwave, and after running the InputFileGenerator, which will generate a txt
file, and the through the command line promt can be run through both the visual and svg view. 
I really enjoyed studying waves in physics, I also think the movemnt of cosine and sine graph waves
also look really cool. Inspired my that and music, I present you the music wave which move between
the crest and trough. This wave also has a random colour generation feature so each time you run 
the animation you will be greeted by a different selection of colors. In the GenerateInput class
I use 2 private helpers which get the information of the rect and manipulate its properties and the 
second helper method composes all the motion.

MANUALLY GENERATED ANIMATION: The manual animation can be generated from the InputFileGenrator. We 
have a method called generate which will use the input which is manually typed out and then uses
string builder and toSting. This is then written to a file which we called sunset.txt, 
the animation we have created consist of 2 buildings, and a tree with the sun shining, 
and then we have a sunset and change in color.  

   