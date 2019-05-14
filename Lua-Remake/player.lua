function loadPlayer()
    local _, _, flags = love.window.getMode()
    width, height = love.window.getDesktopDimensions(flags.display)
    love.graphics.setDefaultFilter('nearest', 'nearest')

    -- temp background
    background = love.graphics.newImage("assets/temp.jpg")

    frame = 0

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
    character.walking = false
    character.sprites = love.graphics.newImage(
                            "assets/Whyatt/whyatt spritesheet.png")

    quads = {}
    quads.down = love.graphics.newQuad(0, 0, 32, 32, character.sprites:getDimensions())
    quads.up = love.graphics.newQuad(32, 0, 32, 32, character.sprites:getDimensions())
    quads.left = love.graphics.newQuad(64, 0, 32, 32, character.sprites:getDimensions())
    quads.right = love.graphics.newQuad(0, 0, 32, 32, character.sprites:getDimensions())

    function character:update()
        dt = love.timer.getDelta()
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

        -- update frames
        frame = frame + 0.1
    end

    function character:draw()
        dt = love.timer.getDelta()
        -- temp background
        love.graphics.draw(background, 0, 0)
        local img = quads.down
        if character.direction == "up" then
            if math.floor(dt) == 1 then
                img = quads.left
            elseif math.floor(dt) == 2 then
                img = quads.right
            end
        elseif character.direction == "down" then

        elseif character.direction == "left" then

        elseif character.direction == "right" then

        end

        love.graphics.draw(character.sprites, img, character.x, character.y, 0,
                           character.scale)

    end

    return character
end
