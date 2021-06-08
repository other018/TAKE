package app;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;

public class Main {
    static String mainUrl = "http://localhost:8080/Complaints/resources/complaints";
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count = client.target("http://localhost:8080/Complaints/" +
                                     "resources/complaints/count")
                             .request(MediaType.TEXT_PLAIN)
                             .get(String.class);
        System.out.println("Count: " + count);
        
        Main.getAll(client);
        Complaint complaint = Main.getById(client, "354");
        Main.updateStatus(client, complaint);
        Main.getAllByStatus(client, "open");
        client.close();
    }
        
    private static void getAll(Client client) {
        String jsonString = client.target(mainUrl)
                             .request(MediaType.APPLICATION_JSON)
                             .get(String.class);
        JSONArray json = new JSONArray(jsonString);
        System.out.println("All complaints: ");
        System.out.println(json.toString(4));
    }
    
    private static Complaint getById(Client client, String id) {
        String jsonString = client.target(mainUrl + "/" + id)
                             .request(MediaType.APPLICATION_JSON)
                             .get(String.class);
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(jsonString, Complaint.class);
        System.out.println("Complaint " + id + ": ");
        complaint.prettyPrint();
        return complaint;
    }
    
    private static void updateStatus(Client client, Complaint complaint) {
        if (complaint.getStatus().equals("closed")) {
            complaint.setStatus("open");
        } else if (complaint.getStatus().equals("open")) {
            complaint.setStatus("closed");
        }
        
        Response response = client.target(mainUrl + "/" + complaint.getId())
                             .request(MediaType.APPLICATION_JSON)
                             .put(Entity.json(complaint));
                
        System.out.println("Put response: " + response);
    }
    
    private static void getAllByStatus(Client client, String status) {
        String jsonString = client.target(mainUrl)
                             .queryParam("status", status)
                             .request(MediaType.APPLICATION_JSON)
                             .get(String.class);
        JSONArray json = new JSONArray(jsonString);
        System.out.println("All " + status + " complaints: ");
        System.out.println(json.toString(4));
    }
}
