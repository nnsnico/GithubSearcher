package com.github.intern.yuji.githubsearcher.model;

/**
 * Created by nns on 2017/08/13.
 */
public class GithubEntity {
    public String description;
    public Owner owner;
    public String language;
    public String name;
    public String stargazers_count;
    public String forks_count;
    public String full_name;
    public String html_url;


    public GithubEntity(String description, Owner owner, String language, String name, String stargazers_count, String forks_count, String full_name, String html_url) {
        this.description = description;
        this.owner = owner;
        this.language = language;
        this.name = name;
        this.stargazers_count = stargazers_count;
        this.forks_count = forks_count;
        this.full_name = full_name;
        this.html_url = html_url;
    }

    class Owner {
        public String received_events_url;
        public String organizations_url;
        public String avatar_url;
        public String gravatar_id;
        public String gists_url;
        public String starred_url;
        public String site_admin;
        public String type;
        public String url;
        public String id;
        public String html_url;
        public String following_url;
        public String events_url;
        public String login;
        public String subscriptions_url;
        public String repos_url;
        public String followers_url;

        public Owner(String received_events_url, String organizations_url, String avatar_url, String gravatar_id, String gists_url, String starred_url, String site_admin, String type, String url, String id, String html_url, String following_url, String events_url, String login, String subscriptions_url, String repos_url, String followers_url) {
            this.received_events_url = received_events_url;
            this.organizations_url = organizations_url;
            this.avatar_url = avatar_url;
            this.gravatar_id = gravatar_id;
            this.gists_url = gists_url;
            this.starred_url = starred_url;
            this.site_admin = site_admin;
            this.type = type;
            this.url = url;
            this.id = id;
            this.html_url = html_url;
            this.following_url = following_url;
            this.events_url = events_url;
            this.login = login;
            this.subscriptions_url = subscriptions_url;
            this.repos_url = repos_url;
            this.followers_url = followers_url;
        }

        @Override
        public String toString() {
            return "Owner{" +
                    "received_events_url='" + received_events_url + '\'' +
                    ", organizations_url='" + organizations_url + '\'' +
                    ", avatar_url='" + avatar_url + '\'' +
                    ", gravatar_id='" + gravatar_id + '\'' +
                    ", gists_url='" + gists_url + '\'' +
                    ", starred_url='" + starred_url + '\'' +
                    ", site_admin='" + site_admin + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", html_url='" + html_url + '\'' +
                    ", following_url='" + following_url + '\'' +
                    ", events_url='" + events_url + '\'' +
                    ", login='" + login + '\'' +
                    ", subscriptions_url='" + subscriptions_url + '\'' +
                    ", repos_url='" + repos_url + '\'' +
                    ", followers_url='" + followers_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GithubEntity{" +
                "description='" + description + '\'' +
                ", owner=" + owner +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", stargazers_count='" + stargazers_count + '\'' +
                ", forks_count='" + forks_count + '\'' +
                ", full_name='" + full_name + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
