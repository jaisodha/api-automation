package pojo;

public class CombinedSlots {
        private boolean cached;
        public CsData data;
        private boolean success;


        // Getter Methods

        public boolean getCached () {
        return cached;
    }

        public CsData getData () {
        return data;
    }

        public boolean getSuccess () {
        return success;
    }

        // Setter Methods

        public void setCached ( boolean cached){
        this.cached = cached;
    }

        public void setData (CsData dataObject){
        this.data = dataObject;
    }

        public void setSuccess ( boolean success){
        this.success = success;
    }
}

