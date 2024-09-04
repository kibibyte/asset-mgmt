package com.myapp.usecase.group;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Group {

  Long id;
  String name;
  String description;
}
