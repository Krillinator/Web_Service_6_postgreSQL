package com.krillinator.demo6.model.response;

import com.krillinator.demo6.model.Todo;

public record TodoResponse(
        Todo todo,
        String message
) {
}
