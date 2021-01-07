<h1>Provider Code Critique</h1>

<h2>Design Critique:</h2>
The code provided to us by our providers was very well designed and relatively
easy to work with. The providers were very good about creating a design that provides immutability 
through ReadOnly and Mutable interfaces for the model and timeline object. In doing this, they were 
able to use a ReadOnly class if only getters are needed and the Mutable class if other methods which 
mutate are necessary. This allows for a more immutable design in which someone must actively choose 
to make a Mutable model or timeline if they need access to those mutating methods, but otherwise 
they can use a ReadOnly class if they only need access to the data. Additionally, their decision to 
use an MVVM (model, view, view-model) design which sets a view-model from which information can
be pulled from was very effective in creating a loosely coupled design. We also found their
decision to extend their interactive view interface from their visual interface to be a good design 
choice since it reuses methods and avoids code duplication.

<h2>Implementation Critique:</h2>
We received textual and interactive view implementations from our providers. We found these views, 
including the visual view which was a supporting class, to be very clear, organized, and well 
thought out. They were all capable and worked as expected. In particular, we found that their user 
interface for their interactive view with buttons for pause/play, a checkbox to toggle looping, and 
a slider to control the speed to be especially nicely formatted and very intuitive. 

<h2>Design/code limitations/suggestions:</h2>
The interfaces that they provided us with were pretty flexible. The only critique we have here was
that they have a relatively complex Timeline object which they utilize to store their data for the 
model. We found this choice to be somewhat overly intricate since the data for the model is 
obtained from a Map<String, Timeline> (each shape’s name mapped to a Timeline) in which a Timeline
is itself a Map<Integer, IReadOnlyShape> (each “key tick” mapped to a shape representing its state 
at that tick). We felt that keeping different states of shapes housed in a shape object at each tick 
was slightly excessive since it would require more work to access shapes/motions from the model and 
would create more work when adding shapes/motions to the model as compared to a design which 
directly stores the data with less levels of depth. When managing this in the getTimelines method 
when implementing their ReadOnly model interface, we felt the Timeline object was very specific and 
not that modular. We struggled to work around that and reuse our code, so we felt this choice made 
their design less flexible. One suggestion we had here was to consolidate the tick mapped to a shape
containing a state into a single object. 

Additionally, we found the getLastTick method in their model to be very useful when knowing when the
end of an animation has been reached, but also thought a getFirstTick method would be helpful for 
knowing when to start an animation. When implementing the interactive controller, it would have been
nice to have a getFirstTick method to know what at tick to reset the animation back to since not
all animations will start at the same tick, sometimes tick 0 or tick 1. As a result, we would
suggest adding a getFirstTick method in the model.

<h2>Documentation Critique:</h2>
Apart from the above-mentioned critique point, their code was convenient to reuse. What made their code really easy to understand was how well they had documented everything (in their README and JavaDocs), how clean their code was, and how they avoided code duplication. 

<h2>Code Change Request:</h2>
We had one point of clarification in which we needed their ShapeFactory class since it was used in their VisualAnimationView (in the setViewModel method) which was extended by the ComplexVisualAnimationView and since it was a supporting class for the interactive view, we needed that. They agreed to this and updated some parts of the code and sent it over to us which would help make their interface and methods work with our model.

