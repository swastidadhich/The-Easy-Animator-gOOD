<h1>READ ME</h1>

We were able to get all features working for this assignment. In order to get the provider's textual
view and interactive view (with a command line argument) to work without modifying either our's
or the provider's code, we used the adapter pattern to implement their necessary model classes
using our model. In doing this, we were able to integrate the provider's textual and interactive
views into our code as expected. In order to get the command line argument -provider to render
the provider's interactive view in our Excellence method, we added in the new command line option
in the main method, and we implemented their controller. Additionally, although we were provided
with a IMutableAnimationModel interface, we did not implement it as we found it was not necessary
for the textual and interactive views to work.

No additional changes were made to our code from the previous assignment.