package net.aydini.jawpdater.util;

/**A popup displaying a loading bar.
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class LoadingScreen{

//	private final Text progressBarText;
//	
//	private ProgressBar progressBar;
//	
//	
//	private static final int FIFTY = 50;
//	
//	
//	private static final int TWOHUNDRED = 200;
//	
//	
//	private static final int CANCEL_BUTTON_HEIGHT = 48;
//
//	public LoadingScreen() {
//		super();
//		this.initStyle(StageStyle.UNDECORATED);
//		this.setResizable(false);
//		this.initModality(Modality.APPLICATION_MODAL);
//		progressBarText = new Text("Suche nach Updates");
//
//		final Scene scene = new Scene(getContainerStackPane(), 300, 70);
//
//		this.setScene(scene);
//		this.setOnCloseRequest(event -> {event.consume();});
//		this.setTitle("Progress");
//		this.setResizable(false);
//	}
//
//	private StackPane getContainerStackPane() {
//		final StackPane stackPane = new StackPane();
//		stackPane.setAlignment(Pos.CENTER);
//		stackPane.getChildren().setAll(getBorderPane());
//		return stackPane;
//	}
//
//	private HBox getBorderPane() {
//		final HBox container = new HBox();
//		final Button buttonCancel = new Button("Abbrechen");
//		buttonCancel.setOnAction(event -> {
//			// cancel operation
//			buttonCancel.setDisable(true);
//			final ProgramStarter ps = new ProgramStarter();
//			ps.startProgramm();
//			this.hide();
//			System.exit(0);
//		});
//
//		buttonCancel.setMinHeight(CANCEL_BUTTON_HEIGHT);
//		container.setAlignment(Pos.CENTER);
//		container.getChildren().add(getStackPane());
//		container.getChildren().add(buttonCancel);
//		return container;
//	}
//
//	/**
//	 * Gets the stackpane with progressbar.
//	 * 
//	 * @return stackpane with progressbar
//	 */
//	private StackPane getStackPane() {
//		progressBar = new ProgressBar(-1.0f);
//		progressBar.setMinHeight(FIFTY);
//		progressBar.setMinWidth(TWOHUNDRED);
//		final StackPane stackPane = new StackPane();
//		stackPane.getChildren().setAll(progressBar, progressBarText);
//		return stackPane;
//	}
}
