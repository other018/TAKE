package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacade;

    //@Size(min=3, max=60, message="Request text must be from 3 to 60 characters long.")
    @Size(min = 3, max = 60, message = "{request.size}")
    private String newRequest;

    private HtmlDataTable requestsDataTable;

    public RequestsList() {
    }

    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }

    public String addRequest() {
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setRequestText(newRequest);
        requestFacade.create(request);
        setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Request req = (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(req);
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
        return null;
    }

    public String getNewRequest() {
        return newRequest;
    }

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

}
