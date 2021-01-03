package de.witchcafe.po;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.ApplicationScope;

@Controller
@ApplicationScope
public class PoDocumentService {

    public TreeNode createDocuments(List<Station> stations, Collection<Water> rivers) {
    	
    	HashMap<String, TreeNode> waterNodes = new HashMap<String, TreeNode>();
    	
        TreeNode root = new DefaultTreeNode(new PoDocument("Pegel Online"), null);
         
        TreeNode documents = new DefaultTreeNode(new PoDocument("Regions"), root);
        TreeNode waters = new DefaultTreeNode(new PoDocument("Waters"), root);
        TreeNode movies = new DefaultTreeNode(new PoDocument("Stations"), root);
        
        for (Water water : rivers) {
            TreeNode waterNode = new DefaultTreeNode(new PoDocument(water), waters);
        	waterNodes.put(water.getId(), waterNode);
        }
        for (Station station : stations) {
            TreeNode waterNode = waterNodes.get(station.getRiver().getId());
            TreeNode stationNode = new DefaultTreeNode(new PoDocument(station), waterNode);
        }
         
        return root;
    }
     
    /*
    public TreeNode createCheckboxDocuments() {
        TreeNode root = new CheckboxTreeNode(new PoDocument("Files", "-", "Folder"), null);
         
        TreeNode documents = new CheckboxTreeNode(new PoDocument("Documents", "-", "Folder"), root);
        TreeNode pictures = new CheckboxTreeNode(new PoDocument("Pictures", "-", "Folder"), root);
        TreeNode movies = new CheckboxTreeNode(new PoDocument("Movies", "-", "Folder"), root);
         
        TreeNode work = new CheckboxTreeNode(new PoDocument("Work", "-", "Folder"), documents);
        TreeNode primefaces = new CheckboxTreeNode(new PoDocument("PrimeFaces", "-", "Folder"), documents);
         
        //Documents
        TreeNode expenses = new CheckboxTreeNode("document", new PoDocument("Expenses.doc", "30 KB", "Word Document"), work);
        TreeNode resume = new CheckboxTreeNode("document", new PoDocument("Resume.doc", "10 KB", "Word Document"), work);
        TreeNode refdoc = new CheckboxTreeNode("document", new PoDocument("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
         
        //Pictures
        TreeNode barca = new CheckboxTreeNode("picture", new PoDocument("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
        TreeNode primelogo = new CheckboxTreeNode("picture", new PoDocument("logo.jpg", "45 KB", "JPEG Image"), pictures);
        TreeNode optimus = new CheckboxTreeNode("picture", new PoDocument("optimusprime.png", "96 KB", "PNG Image"), pictures);
         
        //Movies
        TreeNode pacino = new CheckboxTreeNode(new PoDocument("Al Pacino", "-", "Folder"), movies);
        TreeNode deniro = new CheckboxTreeNode(new PoDocument("Robert De Niro", "-", "Folder"), movies);
         
        TreeNode scarface = new CheckboxTreeNode("mp3", new PoDocument("Scarface", "15 GB", "Movie File"), pacino);
        TreeNode carlitosWay = new CheckboxTreeNode("mp3", new PoDocument("Carlitos' Way", "24 GB", "Movie File"), pacino);
         
        TreeNode goodfellas = new CheckboxTreeNode("mp3", new PoDocument("Goodfellas", "23 GB", "Movie File"), deniro);
        TreeNode untouchables = new CheckboxTreeNode("mp3", new PoDocument("Untouchables", "17 GB", "Movie File"), deniro);
         
        return root;
    }
    */
}
