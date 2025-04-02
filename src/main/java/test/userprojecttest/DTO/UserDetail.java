package test.userprojecttest.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetail {

    @JsonProperty("first_name")
    private Optional<String> firstName;

    @JsonProperty("last_name")
    private Optional<String> lastName;

    @JsonProperty("tlf")
    private Optional<Integer> tlf;

    @JsonProperty("company_id")
    private Optional<Long> companyId;
}
