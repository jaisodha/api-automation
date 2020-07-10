package pojo;

import java.util.List;

public class HomeCardsDataSessionsInfo {
    private String active_session;
    List<HomeCardsDataSessionsInfoSessions> sessions;

    public String getActive_session() {
        return active_session;
    }

    public void setActive_session(String active_session) {
        this.active_session = active_session;
    }

    public List<HomeCardsDataSessionsInfoSessions> getSessions() {
        return sessions;
    }

    public void setSessions(List<HomeCardsDataSessionsInfoSessions> sessions) {
        this.sessions = sessions;
    }
}
