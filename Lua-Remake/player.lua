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
    character.sprites = {}
    character.sprites.up = love.graphics.newImage("assets/Whyatt/whyatt up.png")
    character.sprites.down = love.graphics.newImage("assets/Whyatt/whyatt down.png")
    character.sprites.left = love.graphics.newImage("assets/Whyatt/whyatt left.png")
    character.sprites.right = love.graphics.newImage("assets/Whyatt/whyatt right.png")


    character.sprites.walking = {}
    character.sprites.walking.up = {}
    character.sprites.walking.up.input = love.graphics.newImage("assets/Whyatt/whyatt up walk.png")
    character.sprites.walking.up.one = love.graphics.newQuad(0, 0, 32, 32, character.sprites.walking.up.input:getDimensions())
    character.sprites.walking.up.two = love.graphics.newQuad(0, 0, 32, 32, 32, character.sprites.walking.up.input:getDimensions())
    character.sprites.walking.down = {}
    character.sprites.walking.down.input = love.graphics.newImage("assets/Whyatt/whyatt down walk.png")
    character.sprites.walking.left = {}
    character.sprites.walking.left.input = love.graphics.newImage("assets/Whyatt/whyatt left walk.png")
    character.sprites.walking.right = {}
    character.sprites.walking.rightinput = love.graphics.newImage("assets/Whyatt/whyatt right walk.png")




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

        --update frames
        frame = frame + 0.1



    end

    function character:draw()
        --temp background
        love.graphics.draw(background, 0, 0)

        love.graphics.draw(character.sprites.walking.up.input, character.sprites.walking.up.one, 0, 0, 0, character.scale)
        if character.walking then
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
        else
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

    end

    return character
end
