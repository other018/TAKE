package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private Boolean border;

    public ColorBean() {
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public Boolean getBorder() {
        return border;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorder(Boolean border) {
        this.border = border;
    }
}
