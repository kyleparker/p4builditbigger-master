/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.gcmjokeserver;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokes.Joker;

/** An endpoint class we are exposing */
@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "gcmjokeserver.builditbigger.gradle.udacity.com",
    ownerName = "gcmjokeserver.builditbigger.gradle.udacity.com",
    packagePath = ""
  )
)
public class JokerEndpoint {

    @ApiMethod(name = "getJoke")
    public JokerBean getJoke() {
        Joker joker = new Joker();

        JokerBean response = new JokerBean();
        response.setData(joker.tellRandomJoke());

        return response;
    }
}
