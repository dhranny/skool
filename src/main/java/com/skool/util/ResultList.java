package com.skool.util;

import com.skool.models.CourseResult;

import java.util.LinkedList;
import java.util.List;

public class ResultList extends LinkedList<CourseResult> {

    public CourseResult getByCourse(Long courseId){
        for (CourseResult result: this ) {
            if (result.getCourseId() == courseId)
                return result;
        }
        throw new IllegalArgumentException("There is no result of this course");
    }
}
