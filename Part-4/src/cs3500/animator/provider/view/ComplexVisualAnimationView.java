package cs3500.animator.provider.view;

import cs3500.animator.provider.controller.Features;

import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Objects;

/**
 * A View which creates a visual representation of an Animation, along with supporting extra
 * features: play, pause, reset, toggle looping, and changing speed.
 */
public class ComplexVisualAnimationView extends VisualAnimationView implements
        IComplexVisualAnimationView {

  private final JCheckBox loopingCheckBox;
  private final JSlider speedSlider;
  private final JLabel speedLabel;

  private Features listener;

  /**
   * Creates a new ComplexVisualAnimationView and constructs the listeners for each button, checkbox
   * and slider.
   */
  public ComplexVisualAnimationView() {
    super();

    this.listener = null;

    JButton playButton = new JButton("Play");
    playButton.addActionListener(event -> this.handlePlay());

    JButton pauseButton = new JButton("Pause");
    pauseButton.addActionListener(event -> this.handlePause());

    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(event -> this.handleReset());

    this.loopingCheckBox = new JCheckBox("Toggle looping");
    this.loopingCheckBox
        .addActionListener(event -> this.handleToggleLooping(this.loopingCheckBox.isSelected()));

    this.speedSlider = new JSlider(JSlider.HORIZONTAL,
        1, 60, 20);
    this.speedSlider
        .addChangeListener(change -> this.handleUpdatedSpeed(this.speedSlider.getValue()));

    this.speedLabel = new JLabel("Speed: 20");

    JPanel topBar = new JPanel();
    topBar.add(playButton);
    topBar.add(pauseButton);
    topBar.add(resetButton);
    topBar.add(this.loopingCheckBox);
    topBar.add(this.speedSlider);
    topBar.add(this.speedLabel);
    // this.setLayout(new BorderLayout());
    this.add(topBar, BorderLayout.PAGE_START);

    // JScrollPane scrollPane = new JScrollPane(this.drawingPanel);
    // this.add(scrollPane, BorderLayout.CENTER);

    this.setMinimumSize(new Dimension(800, this.getPreferredSize().height));
    this.setVisible(true);
  }

  @Override
  public void setFeaturesListener(Features listener) {
    this.listener = Objects.requireNonNull(listener);
  }

  @Override
  public void setDisplayedSpeed(int speed) {
    this.speedLabel.setText(String.format("Speed: %d", speed));
    this.speedSlider.setValue(speed);
  }

  @Override
  public void handlePlay() {
    if (this.listener != null) {
      this.listener.resume();
    }
  }

  @Override
  public void handlePause() {
    if (this.listener != null) {
      this.listener.pause();
    }
  }

  @Override
  public void handleReset() {
    if (this.listener != null) {
      this.listener.reset();
    }
  }

  @Override
  public void handleToggleLooping(boolean shouldLoop) {
    if (this.listener != null) {
      this.listener.setLooping(shouldLoop);
    }
  }

  @Override
  public void handleUpdatedSpeed(int speed) {
    if (this.listener != null) {
      this.listener.setSpeed(speed);
    }
  }

}
