package org.acme.Dto;

import java.util.Objects;

public class StatusDTO {
    private String status;

    public StatusDTO() {
    }

    public StatusDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String setStatus(String status) {
        return this.status = status;
    }

    public StatusDTO status(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StatusDTO)) {
            return false;
        }
        StatusDTO statusDTO = (StatusDTO) o;
        return Objects.equals(status, statusDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status);
    }

    @Override
    public String toString() {
        return "{" +
                " status='" + getStatus() + "'" +
                "}";
    }

}
