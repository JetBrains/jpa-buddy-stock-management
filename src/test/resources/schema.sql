CREATE TABLE product
(
    id              UUID         NOT NULL,
    name            VARCHAR(255) NOT NULL,
    product_type_id UUID         NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_type
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_product_type PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCT_TYPE FOREIGN KEY (product_type_id) REFERENCES product_type (id);