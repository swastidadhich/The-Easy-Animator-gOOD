package cs3500.animator.view;

import cs3500.animator.model.Canvas;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.drawing.DrawingPanel;
import cs3500.animator.view.drawing.IViewShape;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.KeyStroke;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Class representing a view of the animation which allows user interaction.
 */
public class InteractiveAnimatorView extends JFrame implements AnimatorInteractive {

  private final DrawingPanel drawingPanel;
  private double tempo;
  private final JButton speedUpButton;
  private final JButton slowDownButton;
  private final JButton restartButton;
  private final JButton loopButton;
  private final JLabel currentSpeed;

  private final int MAX_SPEED = 100;
  private final int MIN_SPEED = 1;

  /**
   * Constructs an InteractiveAnimatorView with a canvas and tempo. Initializes the buttons,
   * label, bounds, and drawing panel.
   * @param canvas canvas
   * @param tempo tempo
   */
  public InteractiveAnimatorView(Canvas canvas, double tempo) {
    super();

    if (canvas == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    if (tempo < 0) {
      throw new IllegalArgumentException("Tempo cannot be negative");
    }

    this.tempo = tempo;

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // set canvas size
    setSize(canvas.getWidth(), canvas.getHeight());
    setBounds(canvas.getX(), canvas.getY(), canvas.getWidth(),
            canvas.getHeight());

    // add drawing panel
    drawingPanel = new DrawingPanel();
    drawingPanel.setPreferredSize(new Dimension(1000, 1000));
    add(drawingPanel);

    // add scroll bars
    JScrollPane scrollPane = new JScrollPane(drawingPanel);
    add(scrollPane);

    // set layout for the view
    this.setLayout(new FlowLayout());

    // main panel to hold the buttons/labels
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    // init buttons/labels;
    speedUpButton = new JButton("Speed Up");
    slowDownButton = new JButton("Slow Down");
    restartButton = new JButton("Restart");
    loopButton = new JButton("Loop disabled"); // empty at start?
    currentSpeed = new JLabel("Current speed: " + tempo); // empty at start?

    // ensure space bar does not trigger button press
    speedUpButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    slowDownButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    restartButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    loopButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");

    // set button action commands
    speedUpButton.setActionCommand("Speed Up");
    slowDownButton.setActionCommand("Slow Down");
    restartButton.setActionCommand("Restart");
    loopButton.setActionCommand("Loop");

    // control panel for the restart and loop button
    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
    controlPanel.setBorder(BorderFactory.createTitledBorder("Main Controls"));
    mainPanel.add(controlPanel);
    JLabel controls = new JLabel("Press space bar to pause/resume");
    controlPanel.add(restartButton);
    controlPanel.add(loopButton);
    controlPanel.add(controls);

    // speed panel for the increase speed, decrease speed, and current speed
    JPanel speedPanel = new JPanel();
    speedPanel.setLayout(new BoxLayout(speedPanel, BoxLayout.PAGE_AXIS));
    speedPanel.setBorder(BorderFactory.createTitledBorder("Speed Controls"));
    mainPanel.add(speedPanel);
    speedPanel.setLayout(new BoxLayout(speedPanel, BoxLayout.PAGE_AXIS));
    speedPanel.add(speedUpButton);
    speedPanel.add(slowDownButton);
    speedPanel.add(currentSpeed);

    pack();

    setVisible(true);
  }

  @Override
  public void setAListener(ActionListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener cannot be null");
    }
    speedUpButton.addActionListener(listener);
    slowDownButton.addActionListener(listener);
    restartButton.addActionListener(listener);
    loopButton.addActionListener(listener);
  }

  @Override
  public void setKListener(KeyListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener cannot be null");
    }
    speedUpButton.addKeyListener(listener);
    slowDownButton.addKeyListener(listener);
    restartButton.addKeyListener(listener);
    loopButton.addKeyListener(listener);
  }

  @Override
  public void render() {
    throw new UnsupportedOperationException("unsupported");
  }

  @Override
  public void render(Shape2D shape, Motion2D motion, int tick) {

    if (shape == null || motion == null) {
      throw new IllegalArgumentException("Shape and/or motion cannot be null");
    }

    if (tick < 0) {
      throw new IllegalArgumentException("Tick cannot be negative");
    }

    Utilities util = new Utilities();
    IViewShape s = util.tween(shape, motion, tick);
    drawingPanel.drawShape(s);

    refresh();
  }

  @Override
  public void speedUp() throws IllegalStateException {
    if (tempo < MAX_SPEED) {
      tempo++;
    }
    else {
      throw new IllegalStateException("At max speed, cannot speed up");
    }
  }

  @Override
  public void slowDown() throws IllegalStateException {
    if (tempo > MIN_SPEED) {
      tempo--;
    }
    else {
      throw new IllegalStateException("At minimum speed, cannot slow down");
    }
  }

  @Override
  public void setCurrentSpeed(double speed) {
    if (speed < 0) {
      throw new IllegalArgumentException("Speed cannot be negative");
    }

    if (tempo <= MIN_SPEED) {
      currentSpeed.setText("Min speed: " + tempo);
    }
    else if (tempo >= MAX_SPEED) {
      currentSpeed.setText("Max speed: " + tempo);
    }
    else {
      currentSpeed.setText("Current speed: " + tempo);
    }
  }

  @Override
  public void setLoopStatus(boolean loop) {
    if (loop) {
      loopButton.setText("Loop enabled");
    }
    else {
      loopButton.setText("Loop disabled");
    }
  }

  @Override
  public double getTempo() {
    return tempo;
  }

  /**
   * Refreshes the drawing panel so that repainting occurs.
   */
  private void refresh() {
    drawingPanel.repaint();
  }

}
