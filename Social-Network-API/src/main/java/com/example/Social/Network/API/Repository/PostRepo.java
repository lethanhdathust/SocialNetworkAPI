package com.example.Social.Network.API.Repository;

import com.example.Social.Network.API.Model.Entity.Post;
//import com.example.Social.Network.API.Model.ResDto.SearchResDto.SearchFunctionResDto;
import com.example.Social.Network.API.Model.ResDto.PostResDto.GetListPostsResDto;
import com.example.Social.Network.API.Model.ResDto.SearchResDto.SearchFunctionResDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long>, PagingAndSortingRepository<Post,Long> {
Post findAllById(long Id);

    @Query("select p," +
//            " t.token as token , " +
            "u.id as user_id " +
            "from User u " +
//            "inner join Token t on t.token = :token " +
            "inner join Post p on u.id = p.user.id and p.described like %:keyword%")
    Page<SearchFunctionResDto> search(@Param("keyword") String keyword,
//                                      @Param("user_id") Long Id,
//                                      @Param("token") String token,
                                      Pageable pageable);

@Query( "select p, u.id as user_id " +
        "from User u  " +
        "inner  join Post p on u.id = p.user.id "


)
    Page<GetListPostsResDto> getListPosts(
            @Param("user_id")Long Id,
//                            @Param("token") String token,
//                            @Param("in_campaign") String inCampaign,
//                            @Param("campaign_id") String campaignId,
//                            @Param("latitude") String latitude,
//                            @Param("longitude") String longitude,
//                            @Param("last_id") String lastId,
                            Pageable pageable );

}
