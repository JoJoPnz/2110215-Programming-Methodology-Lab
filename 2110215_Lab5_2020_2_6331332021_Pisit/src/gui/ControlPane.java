	package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private ItemPane itemPane;
	private Button harvestButton;
	private Label moneyLabel;
	
	public ControlPane () {
		// TODO complete the ControlPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(15);
		this.setFillWidth(true);
		
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		moneyLabel = new Label();
		moneyLabel.setFont(new Font("Arial", 20));
		setMoneyLabelText();
		
		Label info = new Label("Please select a seed or removal tool");
		info.setFont(new Font("Arial", 14));
		
		ItemPane itemPane = new ItemPane();
		
		Button harvestButton = new Button("Harvest");
		harvestButton.setPrefWidth(150);
		harvestButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SimulationManager.harvestHandler();
			}
		});
		
		this.getChildren().addAll(moneyLabel, info, itemPane, harvestButton);
		
	}

	public void setMoneyLabelText() {
		moneyLabel.textProperty().setValue("Money: " + SimulationManager.getMoney());		
	}

	public ItemPane getItemPane() {
		return itemPane;
	}

	public void setItemPane(ItemPane itemPane) {
		this.itemPane = itemPane;
	}

	public Button getHarvestButton() {
		return harvestButton;
	}

	public void setHarvestButton(Button harvestButton) {
		this.harvestButton = harvestButton;
	}

	public Label getMoneyLabel() {
		return moneyLabel;
	}

	public void setMoneyLabel(Label moneyLabel) {
		this.moneyLabel = moneyLabel;
	}
	
	
	
	
	
}
