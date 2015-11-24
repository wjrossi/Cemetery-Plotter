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
- If the person is interred, with an associated PlotID selecting their name in the people list will select the corresponding PlotID from the plots list and allow you to edit their associated information.
- Searching the people list can be done with a partial name or PlotID, if one exists.
	- Search by:
		- Lastname Firstname -- commas are ignored
		- Lastname
		- Firstname

## Viewing & Manipulating Records

