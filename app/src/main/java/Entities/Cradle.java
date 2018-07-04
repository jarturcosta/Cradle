package Entities;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class Cradle {

    private List<Baby> babyList;
    private PreferenceList prefs;
    private Context context;

    public Cradle(Context context) {
        this.babyList = new ArrayList<>();
        this.prefs = new PreferenceList();
        this.context = context;
    }

    public void addBaby(Baby b) {
        babyList.add(b);
    }

    public void saveCradle() {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root
            Document doc = docBuilder.newDocument();
            Element cradle = doc.createElement("cradle");
            doc.appendChild(cradle);

            //babies
            for(int i = 0; i < babyList.size(); i++) {
                Baby b = babyList.get(i);
                Element baby = doc.createElement("Baby");
                cradle.appendChild(baby);
                baby.setAttribute("id",Integer.toString(i));

                //name
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(b.getName()));
                baby.appendChild(name);

                //dad name
                Element dadName = doc.createElement("dadName");
                dadName.appendChild(doc.createTextNode(b.getDadName()));
                baby.appendChild(dadName);

                //mom name
                Element momName = doc.createElement("momName");
                momName.appendChild(doc.createTextNode(b.getMomName()));
                baby.appendChild(momName);

                //height
                Element height = doc.createElement("momName");
                height.appendChild(doc.createTextNode(Double.toString(b.getHeight())));
                baby.appendChild(height);

                //mom name
                Element weight = doc.createElement("weight");
                height.appendChild(doc.createTextNode(Double.toString(b.getWeight())));
                baby.appendChild(weight);

                //birthday
                Element birthday = doc.createElement("birthday");
                birthday.appendChild(doc.createTextNode(b.getBirthday().toString()));
                baby.appendChild(birthday);

                //health
                Element healthInfo = doc.createElement("healthInfo");
                    //past diseases
                    Element pastDiseases = doc.createElement("pastDiseases");
                    for(Map.Entry<String,Integer> entry: b.getHealthInfo().getPastDiseases().entrySet()) {
                        Element diseaseName = doc.createElement("diseaseName");
                        diseaseName.appendChild(doc.createTextNode(entry.getKey()));
    
                        Element occurrences = doc.createElement("occurrences");
                        occurrences.appendChild(doc.createTextNode(Integer.toString(entry.getValue())));
    
                        pastDiseases.appendChild(diseaseName);
                        pastDiseases.appendChild(occurrences);
                    }
                    healthInfo.appendChild(pastDiseases);
                    //current diseases
                    Element currentDiseases = doc.createElement("currentDiseases");
                    for(String d: b.getHealthInfo().getCurrentDiseases()) {
                        Element diseaseName = doc.createElement("diseaseName");
                        diseaseName.appendChild(doc.createTextNode(d));
                        currentDiseases.appendChild(diseaseName);
                    }
                    healthInfo.appendChild(currentDiseases);
                    //vaccines
                    Element vaccines = doc.createElement("vaccines");
                    for(Vaccine v: b.getHealthInfo().getVaccines()) {
                        Element vaccineName = doc.createElement("vaccineName");
                        vaccineName.appendChild(doc.createTextNode(v.getName()));
    
                        Element vaccineTime = doc.createElement("vaccineTime");
                        vaccineTime.appendChild(doc.createTextNode(v.getTime().toString()));
    
                        Element vaccineDesc = doc.createElement("vaccineDesc");
                        vaccineDesc.appendChild(doc.createTextNode(v.getDescription()));
                    }
                    healthInfo.appendChild(vaccines);
                    //appointments
                    Element appointments = doc.createElement("appointments");
                    for(Appointment a: b.getHealthInfo().getMedicalAppointments()) {
                        Element appointmentTime = doc.createElement("appointmentTime");
                        appointmentTime.appendChild(doc.createTextNode(a.getTimeOfAppointment().toString()));
    
                        Element appointmentLocal = doc.createElement("appointmentLocal");
                        appointmentLocal.appendChild(doc.createTextNode(a.getLocal()));
    
                        Element appointmentDoctor = doc.createElement("appointmentDoctor");
                        appointmentDoctor.appendChild(doc.createTextNode(a.getDoctor()));
    
                        Element appointmentLocation = doc.createElement("appointmentLocation");
                        appointmentLocation.appendChild(doc.createTextNode(a.getLocation().toString()));
    
                        Element appointmentDesc = doc.createElement("appointmentDesc");
                        appointmentDesc.appendChild(doc.createTextNode(a.getDescription()));
                    }
                    healthInfo.appendChild(appointments);
                    //health description
                    Element description = doc.createElement("description");
                    description.appendChild(doc.createTextNode(b.getHealthInfo().getDescription()));
                    baby.appendChild(description);
                    //sleeps
                    Element sleeps = doc.createElement("sleeps");
                    for(Sleep v: b.getHealthInfo().getSleepList()) {
    
                        Element sleepStart = doc.createElement("sleepStart");
                        sleepStart.appendChild(doc.createTextNode(v.getStart().toString()));
    
                        Element sleepEnd = doc.createElement("sleepEnd");
                        sleepEnd.appendChild(doc.createTextNode(v.getEnd().toString()));
    
                        Element sleepInterruptions = doc.createElement("sleepInterruptions");
                        sleepInterruptions.appendChild(doc.createTextNode(Integer.toString(v.getNumberOfInterruptions())));
    
                        Element sleepTimeOfSleep = doc.createElement("sleepTimeOfSleep");
                        sleepTimeOfSleep.appendChild(doc.createTextNode(Long.toString(v.getTimeOfSleep())));
                    }
                    healthInfo.appendChild(sleeps);
                    //diapers
                    Element diapers = doc.createElement("diapers");
                    for(Diaper d: b.getHealthInfo().getDiaperList()) {
    
                        Element diaperContent = doc.createElement("diaperContent");
                        diaperContent.appendChild(doc.createTextNode(d.getContent().name()));
    
                        Element diaperTime = doc.createElement("diaperTime");
                        diaperTime.appendChild(doc.createTextNode(d.getTimeOfCheck().toString()));

                        Element diaperDesc = doc.createElement("diaperDesc");
                        diaperDesc.appendChild(doc.createTextNode(d.getDescription()));
                    }
                    healthInfo.appendChild(diapers);
                baby.appendChild(healthInfo);
                
                //Food
                Element foodInfo = doc.createElement("foodInfo");
                    //Intolerances
                    Element intolerances = doc.createElement("intolerances");
                    for(String into: b.getFoodInfo().getIntolerances()) {
                        Element intolerance = doc.createElement("intolerance");
                        intolerance.appendChild(doc.createTextNode(into));
                        intolerances.appendChild(intolerance);
                    }
                    foodInfo.appendChild(intolerances);
                    //Favorites
                    Element favorites = doc.createElement("favorites");
                    for(String f: b.getFoodInfo().getFavorites()) {
                        Element favorite = doc.createElement("favorite");
                        favorite.appendChild(doc.createTextNode(f));
                        favorites.appendChild(favorite);
                    }
                    foodInfo.appendChild(favorites);
                    //Feeding schedule
                    Element feedingSchedule = doc.createElement("feedingSchedules");
                    for(FeedingEntry f: b.getFoodInfo().getFeedingSchedule().getFeedingEntryList()) {
                        Element feedingEntry = doc.createElement("feedingEntry");
                            Element timeOfFeeding = doc.createElement("timeOfFeeding");
                            timeOfFeeding.appendChild(doc.createTextNode(f.getTimeOfFeeding().toString()));

                            Element totalDurationOfFeeding = doc.createElement("totalDurationOfFeeding");
                            totalDurationOfFeeding.appendChild(doc.createTextNode(Integer.toString(f.getTotalDurationOfFeeding())));

                            Element notes = doc.createElement("notes");
                            for(String n: f.getNotes()) {
                                Element note = doc.createElement("note");
                                note.appendChild(doc.createTextNode(n));
                            }

                            feedingEntry.appendChild(timeOfFeeding);
                            feedingEntry.appendChild(totalDurationOfFeeding);
                            feedingEntry.appendChild(notes);

                        feedingSchedule.appendChild(feedingEntry);
                    }
                    foodInfo.appendChild(feedingSchedule);
                baby.appendChild(foodInfo);

                //Journal
                Element journal = doc.createElement("journal");
                    //entry list
                    Element entryList = doc.createElement("entryList");
                    for(JournalEntry j: b.getJournal().getEntryList()) {
                        Element entryDate = doc.createElement("entryDate");
                        entryDate.appendChild(doc.createTextNode(j.getEntryDate().toString()));
                        
                        Element title = doc.createElement("title");
                        title.appendChild(doc.createTextNode(j.getTitle()));

                        Element entryBody = doc.createElement("entryBody");
                        entryBody.appendChild(doc.createTextNode(j.getEntryBody()));

                        Element author = doc.createElement("author");
                        author.appendChild(doc.createTextNode(j.getAuthor()));

                        entryList.appendChild(entryDate).appendChild(title).appendChild(entryBody).appendChild(author);
                    }
                    journal.appendChild(entryList);
                baby.appendChild(journal);
            }

            //preferences
            Element preferences = doc.createElement("preferences");
            //TODO : Add preferences fields do xml file
            cradle.appendChild(preferences);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(context.getFilesDir().getPath()+"/cradle.xml"));

            // Output to console for testing
            StreamResult resultConsole = new StreamResult(System.out);

            transformer.transform(source, result);
            transformer.transform(source, resultConsole);


            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerConfigurationException tce) {
            tce.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void loadCradle() {

        try {
            File fXmlFile = new File(context.getFilesDir().getPath()+"/cradle.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Baby");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Baby name: " + eElement.getElementsByTagName("name").item(0).getTextContent());

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
