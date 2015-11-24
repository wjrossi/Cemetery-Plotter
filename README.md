# CemeteryPlotter v1.0

Welcome to CemeteryPlotter cemetery management software!

## Loading the Program and Opening Files
When CemeteryPlotter opens, no file is loaded.

To start a new file: 
- from this state, simply start adding sections and plots and information.
- or click File->New to start a new file at any time.

To open an existing file, click:
- File->Open, and select a Cemetery DB (.db) file from your computer.
- File->Open from Cloud, and automatically open the most recent Cemetery DB file saved to the cloud.

## Viewing & Manipulating Elements of the Cemetery
### Sections
To add a new section to the cemetery:
- Click the New Section button in the sections panel.
- Choose a name for the section when prompted.
- The section will be created as long as the name you chose does not already exist.

To delete a section or multiple sections:
- Select them in the sections list and click the Delete Section(s) button.
- You will be prompted to confirm your choice.
	- This action cannot be undone, except by exiting the program WITHOUT saving OR by opening the file again.
		- This should revert any changes you made to the most recent save.

To view the plots in a section or section(s)
- Select the specific sections you want to view.  The plots will appear in the plot list and the people will appear in the people list.
- The Select All and Select None buttons are shortcuts for viewing all sections and clearing any selection.

### Plots
To add a new plot:
- Ensure a single section is selected and click the New Plot button.
	- A plot with the next available PlotID is automatically generated and added to the selected section.

To delete a plot:
- Select the plot to be deleted in the plot list and click the Delete Plot button.
- Again, you will be prompted to confirm your choice.
- This action cannot be undone, except by exiting the program WITHOUT saving OR by opening the file again.
		- This should revert any changes you made to the most recent save.

To find quickly find a plot in the plots list:
- Type begin typing a PlotID in the text field above the plots list.
- A partial search will narrow down the list.
- Once the results are narrowed down to a single plot, that plot will automatically be selected.

### People
The people list is based on the currently selected sections.
- It can be filtered to show only the interred people, contacts, or both groups.
- If the person is interred, with an associated PlotID selecting their name in the people list will select the corresponding PlotID from the plots list and allow you to edit their associated records.
- Searching the people list can be done with a partial name or PlotID, if one exists.
	- Search by:
		- Lastname Firstname -- commas are ignored
		- Lastname
		- Firstname

## Viewing & Manipulating Records
To view the records associated with a plot or a person:
- select the desired section(s) containing the plot(s)
- select the PlotID in the plot list or the interred person in the people list.

This will load the: 
- associated plot, interred person, and contact records in the center panels.
- If a map location is set for the chosen plot, it will be highlighted in the map panel.

To edit any plot, interred person, or contact record:
- Click the respective Edit button
- All fields will be unlocked and the edit button will be disabled until you click:
	- Cancel -- reverts any changes you made to the record
	- Delete -- deletes the record
		- This action cannot be undone, except by exiting the program WITHOUT saving OR by opening the file again
	- Update -- update the record with any changes made
		- To make these changes permanent, the cemetery file must be saved.

### Plot
- The Section is automatically set to the section the plot was created in, but may be changed to any existing section.
- The PlotID is automatically generated and not editable.
- All other fields are optional
- To set a Map Location, click Edit on the Plot panel
	- Click the correspond location on the map.  The Map Location field will be filled in automatically.
		- You can click as many times as you want. 

### Interred
- An interred record is not automatically created when a plot is created.
	- While viewing a plot, click Edit on the Interred panel to start a record for an associated interred person.
	- The InterredID is automatically generated, but can be changed to any non-existing InterredID number.
	- The PlotID is automatically associated with the currently selected plot.
- All other fields are optional

### Contact
- A contact record is not automatically created when a plot is created.
- The associated PlotID is automatically added to the list of associated/owned plots when the contact record is created.
- Add a plot by clicking Add Plot and chosing an existing PlotID in the prompt.
- Remove a plot by selecting the plot in the associated/owned plots list and click Remove Plot.

## Saving
To save any changes you made to the cemetery click:
- File->Save to overwrite the current file
- File->Save As to save the cemetery as a new file.  Make sure it uses the file extension ".db".

To save the cemetery file to the cloud:
- Save the file to your computer using one of the two methods above.
- Then click File->Save to Cloud, and your file will be automatically sent to the cloud.
