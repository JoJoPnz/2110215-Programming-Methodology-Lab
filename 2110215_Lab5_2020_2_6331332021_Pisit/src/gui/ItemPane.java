package gui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane{

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();
	
	public ItemPane () {
		// TODO implements the ItemPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		
		
		String[] item = {"Corn","Coffee","Blueberry","Strawberry","Pineapple","DestroyTool"};
		for (String name : item) {
			itemButtonList.add(new ItemButton(name));
		}
		
		for (ItemButton itemButton : itemButtonList) {
			itemButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (SimulationManager.getMoney() >= itemButton.getItem().getPrice()) {
						setSelectedButton(itemButton);
					}
				}
			});
			
			
		}
		
		this.addRow(0, itemButtonList.get(0), itemButtonList.get(1), itemButtonList.get(2));
		this.addRow(1, itemButtonList.get(3), itemButtonList.get(4), itemButtonList.get(5));
		
	} 

	public void setSelectedButton ( ItemButton selecteditemButton ) {
		// TODO set selectedItemButton of SimulationManager to given ItemButton
		// resetButtonsBackgroundColor and the highlight the selecteditemButton
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		// TODO unhighlight each button in itemButtonList
		for (ItemButton itemButton : itemButtonList) {
			itemButton.unhighlight();
		}
	}	
	
}
