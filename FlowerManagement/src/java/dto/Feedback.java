
package dto;

import java.sql.Date;

public class Feedback {
    private int feedbackID;
    private Date feedbackDate;
    private String comment;
    private int cusID;

    public Feedback() {
        feedbackID = 0;
        feedbackDate = null;
        comment = "";
        cusID = 0;
    }

    public Feedback(int feedbackID, Date feedbackDate, String comment, int cusID) {
        this.feedbackID = feedbackID;
        this.feedbackDate = feedbackDate;
        this.comment = comment;
        this.cusID = cusID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }   
}
