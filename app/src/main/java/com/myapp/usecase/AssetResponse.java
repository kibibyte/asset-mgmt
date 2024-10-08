package com.myapp.usecase;

import com.myapp.usecase.asset.AssetType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AssetResponse {

  Long id;
  String name;
  String description;
  AssetType type;
}
