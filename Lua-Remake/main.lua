require "tiledmap"
function love.load()
    _G.map = loadTiledMap("assets/Tiled/tilemap")
    local _, _, flags = love.window.getMode()
    width, height = love.window.getDesktopDimensions(flags.display)
    love.graphics.setDefaultFilter('nearest', 'nearest')
    love.window.setFullscreen(true)

    player = {}
    player.x = width/2
    player.y = height/2
    player.scale = 4
    player.speed = 2
    player.canMove = true
    player.sprites = {}
    player.sprites.down = love.graphics.newImage("assets/Whyatt/whyatt down.png")

end

function love.update(dt)
    if love.keyboard.isDown("w") and player.canMove then
        player.y = player.y - player.speed
    elseif love.keyboard.isDown("s") and player.canMove then
        player.y = player.y + player.speed
    end

    if love.keyboard.isDown("a") and player.canMove then
        player.x = player.x - player.speed
    elseif love.keyboard.isDown("d") and player.canMove then
        player.x = player.x + player.speed
    end
end

function love.draw()
    _G.map:draw()
    love.graphics.draw(player.sprites.down, player.x, player.y, 0, player.scale, player.scale)
end

function love.keypressed(key, scancode, isrepeat)
   if key == "escape" then
      love.event.quit()
   end
end