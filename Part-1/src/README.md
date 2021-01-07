MODEL DESIGN:
The AnimatorModel interface states the methods necessary for an animation
model which include startAnimation which takes directions and initializes
the fields for the model at starting tick1. The other main method within
the interface is updateAnimation which takes a tick and updates/mutates
the model's current fields to represent the animation's state at the given
tick.

EasyAnimatorModel implements the interface. Contains fields llom, a list of list
of motions (one list of motions per each shape in the animation), tick, to
represent the animation's current tick, and los, a list of shapes to 
represent the current state of the shapes at the tick. Also contains fields
frameWidth and frameHeight which set the boundaries for how much of an
animation is seen. We decided to allow shapes to have positions that go
beyond the boundaries, but have created the following invariant.

INVARIANT: the animator model cannot contain a set of directions
(llom field in the model) with a shape with dimensions greater than
the dimensions defined by the frameHeight and frameWidth in the model.
This invariant is enforced in line 52 of the EasyAnimatorModel class
which ensures that every motion within a list of list of motions does
not contain a shape with a width greater than frameWidth or a height
greater than frameHeight.

Motion2D class contains a name of the shape whose motion it determines,
an initial shape, final shape, starting tick, and ending tick.

Shape2D is an abstract class which contains fields for a shape: color,
width, height, and Position2D for the shape's center. Classes Rectangle,
Ellipse, Circle, and Square extend this abstract class. Circle and Square
use a constructor which does not take a height but instead initializes
the height as the same as the width.

Color class contains fields for an RGB color, has fields for red, blue,
and green values.


VIEW (TEXT) DESIGN:
The AnimatorView interface contains a render method which renders the model.

EasyAnimatorView implements this interface and creates a textual
representation of the model by listing the model's directions with
a shape's name, starting values and ending value in the following order:
(tick, x-pos, y-pos, width, height, red, green, blue). This is done
for all motions in the model's directions.