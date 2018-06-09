package lazy.entity;

public class JsonDto {
    private Long id;
    private String telType;
    private String telNumber;

    public JsonDto() {
    }

    public JsonDto(Long id, String telType, String telNumber) {
        this.id = id;
        this.telType = telType;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonDto)) return false;

        JsonDto jsonDto = (JsonDto) o;

        if (id != null ? !id.equals(jsonDto.id) : jsonDto.id != null) return false;
        if (telType != null ? !telType.equals(jsonDto.telType) : jsonDto.telType != null) return false;
        return telNumber != null ? telNumber.equals(jsonDto.telNumber) : jsonDto.telNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JsonDto{");
        sb.append("id=").append(id);
        sb.append(", telType='").append(telType).append('\'');
        sb.append(", telNumber='").append(telNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
