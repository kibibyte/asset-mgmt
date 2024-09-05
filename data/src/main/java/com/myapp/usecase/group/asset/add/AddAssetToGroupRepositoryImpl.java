package com.myapp.usecase.group.asset.add;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.AssetEntity;
import com.myapp.usecase.GroupEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class AddAssetToGroupRepositoryImpl implements AddAssetToGroupRepository {

  private EntityManager entityManager;

  @Override
  @Transactional
  public void add(Long groupId, Long assetId) {
    findGroup(groupId).ifPresent(groupEntity -> {
      findAsset(assetId).ifPresent(assetEntity -> {
            groupEntity.getAssets().add(assetEntity);
          }
      );
    });
  }

  public Optional<GroupEntity> findGroup(Long groupId) {
    return ofNullable(entityManager.find(GroupEntity.class, groupId));
  }

  public Optional<AssetEntity> findAsset(Long assetId) {
    return ofNullable(entityManager.find(AssetEntity.class, assetId));
  }
}
