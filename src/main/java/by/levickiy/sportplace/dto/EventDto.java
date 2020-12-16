package by.levickiy.sportplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    @NotBlank(message = "Enter the event name")
    @Size(min = 5, message = "Event name must contains at least 5 symbols")
    private String name;
    @NotNull(message = "Start date can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @NotNull(message = "Start date can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishDate;
    @NotBlank(message = "Select place name")
    private String placeName;
}
