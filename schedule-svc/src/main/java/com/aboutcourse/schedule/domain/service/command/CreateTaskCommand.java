package com.aboutcourse.schedule.domain.service.command;

import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskCommand {

    private Long userId;

    private String title;

    private Date startDate;

    private Date dueDate;

    private Date startTime;

    private Date endTime;

    private boolean period;

    private RepeatType repeat = RepeatType.NONE;

    @Builder.Default
    private List<TagItem> tags = new ArrayList<>();

    private String info;

    public static class TagItem {

        public TagItem(Long id, String label) {
            this.id = id;
            this.label = label;
        }

        private Long id;

        private String label;

        public Long getId() {
            return this.id;
        }

        public String getLabel() {
            return this.label;
        }

    }
}
