MODEL DESIGN:
Previously our model design for an animation required all shapes and motions
to be added at once. This design was not ideal since it required a complex
list of list of motions containing all info to be input all at once. We have
changed our design for the model by allowing information about the animation
to be added individually as shapes and motions. As a result of this, our model
interface contains methods addShape and addMotion as well as getters.

EasyAnimatorModel implements this interface. We have fields directions, which
is a hashmap of shapes mapped to a list of motions, and a canvas field which
contains the dimensions of the area on which the shapes will be displayed. A
linked hashmap was used for the directions to maintain the order of elements
added to it.

The addShape method operates by taking in a shape name and type and adding an
element to the directions hashmap mapped to an empty list of motions. The
addMotion method operates by taking in arguments of a motion and a name. If
a matching shape name exists in the hasmap, a motion is added to that shape's
list of motions. This method also insures that no motions are added that cause
overlap with already existing motions. Other methods include getters such as 
getShapes, getDirections, and getMotionsFromShape (takes a shape and returns its
list of motions). We also have an initCanvas which initializes the canvas, and
canvas getters, getCanvasX, getCanvasY, getCanvasWidth, and getCanvasHeight.

We have changed our invariant from last assignment to be:
INVARIANT: the easy animator model does not contain directions with elements
who have a shape mapped to a list of motions who have overlapping ticks. This
invariant means that for every shape added to the model, that shape cannot
be mapped to a list of motions which have overlapping ticks. Overlapping ticks
being that motions are allowed to share a starting or ending tick but cannot
overlap more than this.


Motion2D class now has fields for a motion name as well as starting and ending
ticks, x and y positions, width and heights, and color values. Previously we had
stored the information for a motion in fields including an initial and final tick,
and a starting and ending Shape2D (which itself had contained fields for x and y
positions, width and height, and rgb color values). The change was made because
rather than nesting the motion data inside a shape, leaving them as direct fields
made the design simpler and the data easier to access.

IShape2D is an interface for a 2D shape which has implementing class Shape2D
containing fields for a shape name and type. We also have getters for these fields.
As explained, Shape2D had fields describing its current state in our previous
implementation. Since we decided it was better that Motion2D keep this info,
Shape2D only needs fields for the name and type, and no longer needed to be abstract.

Additionally, since Motion2D keeps the rgb color values, we removed the Color class we 
had in our previous implementation.


VIEW DESIGN:
The AnimatorView interface contains a render method which renders the model.

TEXTUAL:
TextualTimeAnimatorView implements the AnimatorView interface and creates a
textual representation of the model by listing the model's directions with
a shape's name, starting values and ending value in the following order:
(time, x-pos, y-pos, width, height, red, green, blue). This is done
for all motions in the model's directions. To get the time, the constructor
takes in a tempo (tick/sec), and the tick is divided by this tempo.
The textual view can take an appendable and append a view as a string,
or it can take a FileWriter containing the name of a file with .txt in which case
it will write to this file and generate a file with the textual representation.

VISUAL:
VisualAnimatorView implements the AnimatorView interface and creates a visual
representation of the model using java swing. The bounds for the animation are
set using the model's canvas and scroll bars were added. A drawing panel was
used to draw the shapes in the model onto for each tick. This was done in the render
method by iterating through the model's shapes, and tweening using the Utilities
class to get the shape's state at the current tick up until the last tick (found
using a method in the utilities class). A refresh method was called each tick
to repaint the shapes.

A drawing package containing view shapes and the drawing panel is in the view. As
explained above, the drawing panel is used by the visual view. The IViewShape interface
is an interface containing a draw method for shapes in the view. This is implemented by
an abstract class containing the common fields for a shape (x, y, width, height, and color).
This abstract class can be extended by shape classes that override the draw method making
the design very extendable. If you want to add a new shape, you create a new class
that extends AbstractViewShape and implement the draw method as suited to that shape.

SVG:
The SVGAnimatorView implements the AnimatorView interface and creates a new .svg file and renders
the animation. The major method used to achieve this is toString - which outputs a string using the
string builder and gets the list of motion from the model. This method can generate various shapes
rectangle, square(which can be generated through a rectangle), ellipse and circle. Animate is the
method which generates a string which will help in moving the shapes when we run the svg file. The
animateTransform method is responsible for generating strings which will help the shapes to be
transformed, based on the input. The method animateMotion is the method which actually gets the
list of motion from the model and helps with the all the translation of the shapes based on the
input from the list of motion. The rest of the method are for generating strings for individual
shapes and their attributes so that they can be generated into an svg file.

EXCELLENCE (MAIN METHOD):
In the excellence class, the main method takes in a command-line argument 
specifying the view type and in file, and optionally the tempo and out file.
The main method pops up an error box if an invalid argument is input, and the
method exits when the error box is closed. When correct arguments are input, the
main method uses the AnimatorViewCreator class, a factory class, to create a
type of view and then renders this view. 


A tempo of 1 tick/second was used for the text-transcript.txt