package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AlarmBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-12T06:02:13.164Z[GMT]")


public class AlarmBody   {
  @JsonProperty("delay")
  private BigDecimal delay = null;

  @JsonProperty("name")
  private String name = null;

  public AlarmBody delay(BigDecimal delay) {
    this.delay = delay;
    return this;
  }

  /**
   * Get delay
   * @return delay
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getDelay() {
    return delay;
  }

  public void setDelay(BigDecimal delay) {
    this.delay = delay;
  }

  public AlarmBody name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlarmBody alarmBody = (AlarmBody) o;
    return Objects.equals(this.delay, alarmBody.delay) &&
        Objects.equals(this.name, alarmBody.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delay, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmBody {\n");
    
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
