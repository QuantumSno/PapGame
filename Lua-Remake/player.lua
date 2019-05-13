function loadPlayer()
    local _, _, flags = love.window.getMode()
    width, height = love.window.getDesktopDimensions(flags.display)
    love.graphics.setDefaultFilter('nearest', 'nearest')

    -- temp background
    background = love.graphics.newImage("assets/temp.jpg")

    character = {}
    character.x = width / 2
    character.y = height / 2
    character.scale = 4
    character.speed = 2
    character.width = 32 * character.scale
    character.height = 32 * character.scale
    character.canMove = true
    character.canMoveUp = true
    character.direction = "down"
    character.sprites = {}
    character.sprites.up = love.graphics.newImage("assets/Whyatt/whyatt up.png")
    character.sprites.down = love.graphics.newImage(
                                 "assets/Whyatt/whyatt down.png")
    character.sprites.left = love.graphics.newImage(
                                 "assets/Whyatt/whyatt left.png")
    character.sprites.right = love.graphics.newImage(
                                  "assets/Whyatt/whyatt right.png")

    function character:update()
        if love.keyboard.isDown("w") and character.canMove and
            character.canMoveUp then
            character.y = character.y - character.speed
            character.direction = "up"
        elseif love.keyboard.isDown("s") and character.canMove and
            character.canMoveUp then
            character.y = character.y + character.speed
            character.direction = "down"
        end

        if love.keyboard.isDown("a") and character.canMove then
            character.x = character.x - character.speed
            character.direction = "left"
        elseif love.keyboard.isDown("d") and character.canMove then
            character.x = character.x + character.speed
            character.direction = "right"
        end
    end

    function character:draw()
        --temp background
        love.graphics.draw(background, 0, 0)

        if character.direction == "up" then
            love.graphics.draw(character.sprites.up, character.x, character.y,
                               0, character.scale)
        elseif character.direction == "down" then
            love.graphics.draw(character.sprites.down, character.x, character.y,
                               0, character.scale)
        elseif character.direction == "left" then
            love.graphics.draw(character.sprites.left, character.x, character.y,
                               0, character.scale)
        elseif character.direction == "right" then
            love.graphics.draw(character.sprites.right, character.x,
                               character.y, 0, character.scale)
        end

    end

    return character
end
