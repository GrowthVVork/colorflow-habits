    INSERT INTO colorflow.category(
        category_name, category_description, category_color)
        VALUES ('Misc', 'Miscellaneous category as a default', '#FFFFFF')
        ON DUPLICATE KEY UPDATE category_name = category_name;