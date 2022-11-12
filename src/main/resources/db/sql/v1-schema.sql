CREATE TABLE tutorial
(
    id        bigint auto_increment,
    title     VARCHAR(300),
    author    VARCHAR(200),
    published BIT,
    CONSTRAINT tutorial_detail_PK PRIMARY KEY (id)
);
