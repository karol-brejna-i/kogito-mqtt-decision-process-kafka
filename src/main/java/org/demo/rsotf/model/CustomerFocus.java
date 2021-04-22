package org.demo.rsotf.model;

public class CustomerFocus {
    private String event_type = "customer focus";
    private int event_timestamp;
    private Payload payload;


    public CustomerFocus() {
    }

    public CustomerFocus(int event_timestamp, Payload payload) {
        this.event_timestamp = event_timestamp;
        this.payload = payload;
    }

    public CustomerFocus(int event_timestamp, String customer_id, String category) {
        this.event_timestamp = event_timestamp;
        this.payload = new Payload(customer_id, category);
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public int getEvent_timestamp() {
        return event_timestamp;
    }

    public void setEvent_timestamp(int event_timestamp) {
        this.event_timestamp = event_timestamp;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "CustomerFocus{" +
                "event_type='" + event_type + '\'' +
                ", event_timestamp=" + event_timestamp +
                ", payload=" + payload +
                '}';
    }

    static class Payload {
        private String customer_id;
        private String category;

        public Payload(String customer_id, String category) {
            this.customer_id = customer_id;
            this.category = category;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "Payload{" +
                    "customer_id=" + customer_id +
                    ", category='" + category + '\'' +
                    '}';
        }

    }
}
