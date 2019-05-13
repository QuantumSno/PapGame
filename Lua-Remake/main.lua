require "player"

function love.load()
    love.window.setFullscreen(true)
    _G.player = loadPlayer()
end

function love.update(dt) _G.player:update() end

function love.draw() _G.player:draw() end

function love.keypressed(key, scancode, isrepeat)
    if key == "escape" then love.event.quit() end
end
