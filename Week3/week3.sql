CREATE DATABASE IF NOT EXISTS social_media_app;

USE social_media_app;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS comments;

CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  email varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE posts (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  content varchar(280) NOT NULL,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (post_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE comments (
  comment_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  post_id int(11) NOT NULL,
  content varchar(280) NOT NULL,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (comment_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (post_id) REFERENCES posts(post_id)
);
