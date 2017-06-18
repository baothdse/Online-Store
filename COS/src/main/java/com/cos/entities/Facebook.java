package com.cos.entities;

import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.FqlOperations;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.GroupOperations;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.MediaOperations;
import org.springframework.social.facebook.api.OpenGraphOperations;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.social.facebook.api.PlacesOperations;
import org.springframework.social.facebook.api.QuestionOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.web.client.RestOperations;

public interface Facebook extends GraphApi{
	CommentOperations commentOperations();

    EventOperations eventOperations();

    FeedOperations feedOperations();

    FqlOperations fqlOperations();

    FriendOperations friendOperations();

    GroupOperations groupOperations();

    LikeOperations likeOperations();

    MediaOperations mediaOperations();

    OpenGraphOperations openGraphOperations();

    PageOperations pageOperations();

    PlacesOperations placesOperations();

    QuestionOperations questionOperations();

    UserOperations userOperations();

    RestOperations restOperations();

    String getApplicationNamespace();
}
